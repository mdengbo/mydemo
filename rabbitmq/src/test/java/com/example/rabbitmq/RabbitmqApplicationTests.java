package com.example.rabbitmq;

import com.example.rabbitmq.productor.MsgProducer;
import com.example.rabbitmq.rabbit.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private Sender sender;
	@Autowired
	MsgProducer msgProducer;

	@Test
	public void hello() throws Exception {
//		sender.send();
		for(int i=0; i< 50 ; i++){
			msgProducer.sendMsg("this message come from  doc ma!!"+"num"+"["+i+"]");
			Thread.sleep(5000);
		}
	}
}
