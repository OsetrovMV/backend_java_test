package com.geekbrains;

import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class MainMarket {
    public static void main(String[] args) throws IOException {

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            Products product =  productsMapper.selectByPrimaryKey(453L);
            System.out.println(product);

            ProductsExample example = new ProductsExample();
            example.createCriteria()
                    .andCategoryIdEqualTo(2L)
                    .andTitleLike("Recorder")
                    .andPriceGreaterThan(55);

            List<Products> products = productsMapper.selectByExample(example);
            System.out.println(products);

            example.clear();
            example.createCriteria()
                    .andCategoryIdEqualTo(1L);

            products = productsMapper.selectByExample(example);
            System.out.println(products);

            productsMapper.deleteByPrimaryKey(453L);
            example.clear();

            example.createCriteria()
                    .andCategoryIdEqualTo(2L)
                    .andTitleLike("Recorder")
                    .andPriceGreaterThan(55);

            products = productsMapper.selectByExample(example);
            System.out.println(products);

        }
    }
}
