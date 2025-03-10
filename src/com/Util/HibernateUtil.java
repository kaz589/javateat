package com.Util;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory factory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
		try {
            // 創建 Hibernate 配置對象
            Configuration configuration = new Configuration().configure();

            // 指定要掃描的包，例如 tw.house.model
            configuration.addPackage("com.model");

            // 建立服務註冊表
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // 建立 SessionFactory
            return configuration.buildSessionFactory(registry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("初始化 Hibernate SessionFactory 時發生錯誤：" + e.getMessage());
        }
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}

}
