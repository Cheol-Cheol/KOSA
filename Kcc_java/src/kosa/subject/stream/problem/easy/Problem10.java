package kosa.subject.stream.problem.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kosa.subject.stream.problem.easy.resources.Customer;

public class Problem10 {

	/**
	 * 주어진 Customer 객체 리스트를 나이(age)별로 그룹화하여 Map으로 반환합니다.
	 *
	 * @param customers Customer 객체 리스트
	 * @return 나이별로 그룹화된 Map
	 */
	public static void main(String[] args) {
		Map<Integer, List<Customer>> map = groupCustomersByAge(Arrays.asList(new Customer(1, "1", 10), new Customer(2, "2", 10),
				new Customer(3, "3", 11), new Customer(1, "4", 13)));
		System.out.println(map);
	}

	public static Map<Integer, List<Customer>> groupCustomersByAge(List<Customer> customers) {
		return customers.stream().collect(Collectors.groupingBy(Customer::getAge));
	}
}