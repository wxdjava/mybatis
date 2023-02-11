package com.wxd.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxd.mybatis.mapper.CarMapper;
import com.wxd.mybatis.pojo.Car;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/11 - 19:42
 */
public class CarMapperTest {

    @Test
    public void testSelectByPage(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int pageNum = 2;
        int pageSize = 3;
        int startIndex = (pageNum - 1) * 3;
        List<Car> cars = mapper.selectByPage(startIndex,pageSize);
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        /*查询语句开始之前开启分页功能*/
        PageHelper.startPage(2,3);
        List<Car> cars = mapper.selectAll();

        /*cars.forEach(car -> {
            System.out.println(car);
        });*/

        /*查询语句结束之后封装PageInfo对象*/
        PageInfo<Car> PageInfo = new PageInfo<>(cars,5);
        System.out.println(PageInfo);
        sqlSession.close();

        /*
        查询结果如下：
        PageInfo{pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=19, pages=7,
            list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=19, pages=7, reasonable=false, pageSizeZero=false}
        [Car{id=11, carNum='100', brand='丰田', guidePrice=20.0, produceTime='2023-01-26', carType='燃油车'},
         Car{id=12, carNum='100', brand='丰田', guidePrice=20.0, produceTime='2023-01-26', carType='燃油车'},
         Car{id=13, carNum='100', brand='丰田', guidePrice=20.0, produceTime='2023-01-26', carType='燃油车'}],
        prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true,
                navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}*/
    }
}
