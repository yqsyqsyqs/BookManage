package cn.gson.bookmanage.common.tool;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils {

	public static boolean isEmptyList(Collection<?> collection) {
		return collection==null||collection.isEmpty();
	}
	
	public static boolean isEmptyMap(Map<?, ?>map) {
		return map==null||isEmptyList(map.keySet());
	}
}