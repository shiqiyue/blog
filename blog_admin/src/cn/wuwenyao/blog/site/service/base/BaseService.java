/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * 
 *******************************************************************************/
package cn.wuwenyao.blog.site.service.base;


import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Lists;



public class BaseService {
	private static Logger logger = LoggerFactory.getLogger(BaseService.class);

	

	/**
	 * 创建分页要求
	 * 
	 * @param @param pageNumber
	 * @param @param pageSize
	 * @param @param sortType
	 * @param @param asc
	 * @param @return
	 * @return PageRequest
	 */
	public PageRequest createPageRequest(int pageNumber, int pageSize,
			String sortType, boolean asc) {
		Sort sort = createSort(sortType, asc);
		return new PageRequest(pageNumber - 1, pageSize, sort);
	}

	/**
	 * 根据用户传进来的信息创建排序信息
	 * 
	 * @param @param sortType
	 * @param @param asc
	 * @param @return
	 * @return Sort
	 */
	public Sort createSort(String sortType, boolean asc) {
		Sort sort = null;
		Direction defaultDirection = asc ? Direction.ASC : Direction.DESC;
		// 设置默认值
		if (StringUtils.isBlank(sortType)) {
			sortType = "id";
		}
		List<Sort.Order> orders = Lists.newArrayList();
		Direction otherDirection;
		for (String sortStr : sortType.split(",")) {
			String[] sortAndDirection = sortStr.split(":");
			if (sortAndDirection.length < 1) {
				continue;
			} else if (sortAndDirection.length == 2) {
				otherDirection = sortAndDirection[1].equalsIgnoreCase("asc") ? Direction.ASC
						: Direction.DESC;
			} else {
				otherDirection = defaultDirection;
			}
			orders.add(new Order(otherDirection, sortAndDirection[0]));
		}
		sort = new Sort(orders);
		return sort;
	}

	/**
	 * 创建动态查询条件组合.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Specification<?> createSpecification(
			Map<String, Object> searchParams, Class entityClass) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification spec = DynamicSpecifications.bySearchFilter(
				filters.values(), entityClass);
		return spec;
	}



}
