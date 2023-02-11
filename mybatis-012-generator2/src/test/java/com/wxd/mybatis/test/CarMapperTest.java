package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.CarMapper;
import com.wxd.mybatis.pojo.Car;
import com.wxd.mybatis.pojo.CarExample;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/11 - 17:07
 */
public class CarMapperTest {

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        Car car = mapper.selectByPrimaryKey(36L);
        System.out.println(car);

        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(car1 -> {
            System.out.println(car1);
        });
        CarExample carExample = new CarExample();
        carExample.createCriteria().andBrandLike("兰博基尼")
                  .andGuidePriceGreaterThan(new BigDecimal(30));
        carExample.or().andCarTypeLike("新能源");
        List<Car> cars2 = mapper.selectByExample(carExample);
        cars2.forEach(car2 -> {
            System.out.println(car2);
        });
        sqlSession.close();
    }
}