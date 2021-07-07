package com.chomolungma.system.cdp;

import com.chomolungma.system.cdp.tree.Org;
import com.chomolungma.system.cdp.tree.OrgEntityMapStruct;
import com.chomolungma.system.cdp.tree.annotation.Pid;
import com.chomolungma.system.cdp.tree.OrgTree;
import com.chomolungma.system.cdp.tree.annotation.Children;
import com.chomolungma.system.cdp.tree.annotation.Id;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CdpApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testTree() throws JsonProcessingException {
		List<Org> orgList = new ArrayList<>();
		Org org = new Org();
		org.setId(1L);
		org.setPid(null);
		org.setName("珠峰科技");
		Org org2 = new Org();
		org2.setId(2L);
		org2.setPid(1L);
		org2.setName("总裁办");
		Org org5 = new Org();
		org5.setId(5L);
		org5.setPid(1L);
		org5.setName("总裁办");
		Org org3 = new Org();
		org3.setId(3L);
		org3.setPid(2L);
		org3.setName("总裁办");

		Org org4 = new Org();
		org4.setId(4L);
		org4.setPid(null);
		org4.setName("总裁办");



		orgList.add(org2);
		orgList.add(org);
		orgList.add(org4);
		orgList.add(org3);
		orgList.add(org5);

		//treeProcessor(orgList, OrgTree.class);

		List<OrgTree> tree = createTree(convertEntity(orgList));
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(tree));


	}

	public List<Org> buildTree(List<Org> oldList){
		Map<Long,Org> listMap = oldList.stream().collect(Collectors.toMap(Org::getId,org->org));

		List<Org> result = new ArrayList<>();

		for (Org org: oldList) {
			Org parent = listMap.get(org.getPid());
			if (parent != null){
				List<Org> ch;
				if (parent.getChildren()==null){
					ch = new ArrayList<>();
				}else{
					ch = org.getChildren();
				}
				ch.add(org);
				parent.setChildren(ch);
			}else{
				result.add(org);
			}
		}



		return result;


	}



	public List<OrgTree> convertEntity(List<Org> oldTree){
		OrgEntityMapStruct oes = Mappers.getMapper(OrgEntityMapStruct.class);
		return oes.orgToOrgTree(oldTree);
	}



	public <T> List<T> createTree(List<T> oldList){
		Map<Long,T> map = new HashMap<>();

		for (T t: oldList) {
			Field[] fields = t.getClass().getDeclaredFields();
			for (Field field: fields) {
				Annotation idAnnotation = field.getAnnotation(Id.class);

				if (idAnnotation != null){
					String idField = field.getName();
					try {
						PropertyDescriptor pd = new PropertyDescriptor(idField,t.getClass());
						Method idMethod = pd.getReadMethod();
						Long id = (Long)idMethod.invoke(t);
						map.put(id,t);
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}

		List<T> treeList = new ArrayList<>();
		for (T t: oldList) {
			Field[] fields = t.getClass().getDeclaredFields();

			for (Field field: fields) {
				Annotation pidAnnotation = field.getAnnotation(Pid.class);

				if (pidAnnotation != null){
					String pidField = field.getName();
					try {
						PropertyDescriptor pd = new PropertyDescriptor(pidField,t.getClass());
						Method pidMethod = pd.getReadMethod();
						Long pid = (Long)pidMethod.invoke(t);

						T parent = map.get(pid);
						if (parent != null){
							Field[] parentFields = parent.getClass().getDeclaredFields();

							for (Field parentField: parentFields) {
								Annotation childrenAnnotation = parentField.getAnnotation(Children.class);

								if (childrenAnnotation != null){
									String childrenField = parentField.getName();


									PropertyDescriptor pdChildren = new PropertyDescriptor(childrenField,parent.getClass());
									Method childrenGetMethod = pdChildren.getReadMethod();
									List<T> children = (List<T>)childrenGetMethod.invoke(parent);

									if (children == null){
										List<T> ch = new ArrayList<>();
										ch.add(t);
										Method childrenSetMethod =pdChildren.getWriteMethod();
										childrenSetMethod.invoke(parent,ch);
									}else{
										List<T> ch =  (List<T>)childrenGetMethod.invoke(parent);
										ch.add(t);
										Method childrenSetMethod =pdChildren.getWriteMethod();
										childrenSetMethod.invoke(parent,ch);

									}


									break;
								}

							}
						}else{
							treeList.add(t);
						}
						break;
					}catch (Exception e){
						e.printStackTrace();
					}
				}

			}

		}

		return treeList;

	}


}
