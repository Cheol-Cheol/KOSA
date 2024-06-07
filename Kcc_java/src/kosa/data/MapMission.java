package kosa.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MapMission {

	public static void main(String[] args) {

		// 이름, 점수를 한쌍으로 Map 자료구조로 구현하시오. ex) 김자바: 90, 박자바: 60
		// 1. 시험 응시자만 출력
		// 2. 총점, 평균, 최고점수, 최저점수 출력 / Collections.max|min

		HashMap<String, Integer> hMap = new HashMap();
		hMap.put("김자바", 90);
		hMap.put("박자바", 60);

//		Iterator<Entry<String, Integer>> iter = hMap.entrySet().iterator();
		Iterator<Integer> iter = hMap.values().iterator();
		int sum = 0;
//		while (iter.hasNext()) {
//			Entry<String, Integer> el = iter.next();
//			sum += el.getValue();
//		}
		while (iter.hasNext()) {
			sum += iter.next();
		}

		System.out.println("총점: " + sum);
		System.out.println("평균: " + sum / hMap.size());
		System.out.println("최고점수: " + Collections.max(hMap.values()));
		System.out.println("최저점수: " + Collections.min(hMap.values()));

	}
}
