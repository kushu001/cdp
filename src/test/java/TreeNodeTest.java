import com.alibaba.fastjson.JSONArray;
import com.chomolungma.app.*;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest<T> {


    public static void main(String[] args) {
        List<Org> list = new ArrayList<>();

    /*    Org org = new Org();
        org.setId(1);
        org.setPid(0);
        org.setName("aa");

        Org org2 = new Org();
        org2.setId(2);
        org2.setPid(0);
        org2.setName("bb");

        Org org3 = new Org();
        org3.setId(3);
        org3.setPid(1);
        org3.setName("cc");

        Org org4 = new Org();
        org4.setId(4);
        org4.setPid(3);
        org4.setName("dd");

        Org org5 = new Org();
        org5.setId(5);
        org5.setPid(3);
        org5.setName("ee");

        list.add(org);
        list.add(org2);
        list.add(org3);
        list.add(org4);
        list.add(org5);*/

        TreeNodeTest<Org> test = new TreeNodeTest<>();
        List<TreeNode<Org>> treeNodes = test.generateTree(list, Org.class);
        System.out.println(JSONArray.toJSONString(treeNodes));
    }

    private  List<TreeNode<T>> generateTree(List<T> allNodes, Class clazz){

        List<TreeNode<T>> roots = getRoots(allNodes,clazz);

        for (TreeNode<T> node:roots){
            node.setChildren(this.getChildren(allNodes,node,clazz));
        }
        return roots;
    }


    private List<TreeNode<T>> getChildren(List<T> allNodes, TreeNode<T> node, Class clazz){
        List<TreeNode<T>> children = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        String idField = null;
        String pidField = null;
        for (Field field: fields) {
            Annotation id = field.getDeclaredAnnotation(Id.class);
            if (id !=null){
                idField = field.getName();
            }

            Annotation pid = field.getDeclaredAnnotation(Pid.class);

            if (pid != null){
                pidField = field.getName();
            }
        }

        try {
            if (idField == null) {
                throw new Exception("Id Annotation does not exist!");
            }

            if (pidField == null) {
                throw new Exception("Pid Annotation does not exist!");
            }

            for (T t: allNodes) {
                PropertyDescriptor pd =  new PropertyDescriptor(pidField, t.getClass());
                Method pidMethod = pd.getReadMethod();
                Integer pid =(Integer)pidMethod.invoke(t);

                PropertyDescriptor nodePd = new PropertyDescriptor(idField, node.getNode().getClass());
                Method nodeIdMethod = nodePd.getReadMethod();
                Integer nodeId =(Integer)nodeIdMethod.invoke(node.getNode());
                if (pid == nodeId){
                    TreeNode<T> treeNode = new TreeNode<>();
                    treeNode.setNode(t);
                    children.add(treeNode);
                }

            }



            for (TreeNode<T> child:children){

                child.setChildren(this.getChildren(allNodes,child,clazz));
            }

            if (children.size() ==0){
                return null;
            }



        }catch (Exception ex){
            ex.printStackTrace();
        }
        return children;
    }


    private List<TreeNode<T>> getRoots(List<T> allNodes, Class clazz){
        List<TreeNode<T>> roots = new ArrayList<>();

        try{
            Annotation nodeAn = clazz.getDeclaredAnnotation(Node.class);
            if (nodeAn == null){
                throw new Exception("Node Annotation does not exist!");
            }

            Field[] fields = clazz.getDeclaredFields();
            String idField = null;
            String pidField = null;
            for (Field field: fields) {
                Annotation id = field.getDeclaredAnnotation(Id.class);
                if (id !=null){
                    idField = field.getName();
                }

                Annotation pid = field.getDeclaredAnnotation(Pid.class);

                if (pid != null){
                    pidField = field.getName();
                }
            }

            if (idField == null){
                throw new Exception("Id Annotation does not exist!");
            }

            if (pidField == null){
                throw new Exception("Pid Annotation does not exist!");
            }


            for (T t: allNodes) {
                PropertyDescriptor pd =  new PropertyDescriptor(pidField, t.getClass());
                Method pidMethod = pd.getReadMethod();
                Integer pid =(Integer)pidMethod.invoke(t);

                if (pid == 0){
                    TreeNode<T> treeNode = new TreeNode<>();
                    treeNode.setNode(t);
                    roots.add(treeNode);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roots;
    }


}
