import com.alibaba.fastjson.JSONArray;
import com.chomolungma.app.Node;
import com.chomolungma.app.Org;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TreeNodeTest2<T> {
    public static void main(String[] args) {
        List<Org> list = new ArrayList<>();

        Org org = new Org();
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
        org5.setDate(new Date());

        list.add(org);
        list.add(org2);
        list.add(org3);
        list.add(org4);
        list.add(org5);


        TreeNodeTest2<Org> test = new TreeNodeTest2<>();

        List<Map<String, Object>> roots = test.generate(list,Org.class);

        System.out.println(JSONArray.toJSONString(roots));


    }


    public List<Map<String, Object>> generate(List<T> allNodes, Class clazz){

        List<Map<String, Object>> roots =this.roots(allNodes,clazz);
        Node nodeAnno = (Node) clazz.getDeclaredAnnotation(Node.class);
        for (Map<String, Object> root:  roots) {
            root.put(nodeAnno.children(),this.children(allNodes,root,clazz));
        }
        return roots;
    }



    private List<Map<String, Object>> roots(List<T> allNodes, Class clazz){
        List<Map<String, Object>> roots = new ArrayList<>();
        Node nodeAnno = (Node) clazz.getDeclaredAnnotation(Node.class);
        try {

            if (nodeAnno == null){
                throw new Exception("Node Annotation does not exist!");
            }

            for (T t: allNodes) {
                PropertyDescriptor pd = new PropertyDescriptor(nodeAnno.pid(),t.getClass());
                Method pidMethod = pd.getReadMethod();
                Integer pid =(Integer)pidMethod.invoke(t);

                if (pid == nodeAnno.root()){
                    children(roots, t);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return roots;
    }



    private List<Map<String, Object>> children(List<T> allNodes, Map<String, Object> node, Class clazz){
        List<Map<String, Object>> children = new ArrayList<>();
        Node nodeAnno = (Node) clazz.getDeclaredAnnotation(Node.class);
        try {

            if (nodeAnno == null){
                throw new Exception("Node Annotation does not exist!");
            }


            for (T t: allNodes) {
                PropertyDescriptor pd = new PropertyDescriptor(nodeAnno.pid(),t.getClass());
                Method pidMethod = pd.getReadMethod();
                Integer pid =(Integer)pidMethod.invoke(t);

                if (pid == node.get(nodeAnno.id())){
                    children(children, t);
                }
            }


            for (Map<String, Object> child: children) {
                 child.put(nodeAnno.children(),this.children(allNodes,child,clazz));
            }

            if (children.size()==0){
                return null;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return children;
    }

    private void children(List<Map<String, Object>> children, T t) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Field[] fields = t.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for (Field field: fields) {
            PropertyDescriptor property = new PropertyDescriptor(field.getName(),t.getClass());
            Method propertyMethod = property.getReadMethod();
            map.put(field.getName(),propertyMethod.invoke(t));
        }
        children.add(map);
    }
}
