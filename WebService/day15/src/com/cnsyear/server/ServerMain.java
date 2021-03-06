package com.cnsyear.server;
 
 
import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws22.EndpointImpl;
import org.apache.cxf.message.Message;

import com.cnsyear.server.interceptor.ServiceInterceptor;

/**
 * 测试启动类
 * 
 * @author jiebaobao
 *
 */
public class ServerMain {
	public static void main(String[] args) {
			String address="http://127.0.0.1:8888/sayHello";//地址
			Endpoint endpoint = Endpoint.publish(address, new ServiceImpl());//发布方法
			EndpointImpl endpointImpl = (EndpointImpl)endpoint;
			
			//服务器端入拦截器
			List<Interceptor<? extends Message>> inInterceptors  = endpointImpl.getInInterceptors();
			inInterceptors.add(new ServiceInterceptor());
			
			
			System.out.println("发布WebSerive成功！"+address);
	}
}
