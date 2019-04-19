package cn.rabbit.mq.topic;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import cn.rabbit.mq.util.ConnectionUtil;

public class Recv2 {

	private final static String QUEUE_NAME = "test_queue_topic_work2";

	private final static String EXCHANGE_NAME = "test_exchange_topic";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		final Channel channel = connection.createChannel();
		
		// 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换机
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "item.*");

		// 同一时刻服务器只会发一条消息给消费者
		channel.basicQos(1);

		// 定义队列的消费者
		Consumer consumer = new DefaultConsumer(channel) {
			// 获取消息并处理，这个方法类似事件监听，如果有消息，会被直接调用
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
				// 手动进行ACK
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		// 监听队列，手动返回完成
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}