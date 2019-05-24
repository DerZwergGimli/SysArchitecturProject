package threads;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class TCommunication extends RealtimeThread {
	// TODO: This is not our final solution..., this is just for getting a brief
	// overview on how to impl. a MQTT-Client in JAVA
	// ... do not use this in your final solution!
	// idk. if this is even ness that we are using threads in here but maybe this is
	// a good idea!

	String topic = "MQTT Examples";
	String content = "Message from MqttPublishSample";
	int qos = 2;
	String broker = "tcp://iot.eclipse.org:1883";
	String clientId = "JavaSample";
	MemoryPersistence persistence = new MemoryPersistence();

	public TCommunication() {
		int threadPriority = PriorityScheduler.instance().getMinPriority() + 3;
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(20 /* ms */, 0 /* ns */); /* period: 20ms */
		PeriodicParameters releaseParameter = new PeriodicParameters(null, period, null, null, null, null);
		setSchedulingParameters(schedulingParameter);
		setReleaseParameters(releaseParameter);

	}

	@Override
	public void run() {
		// TODO: somehow we have to ensure that our theard is running only 20 ms

		int n = 1;
		while (waitForNextPeriod() && (n < 100)) {
			try {
				MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
				MqttConnectOptions connOpts = new MqttConnectOptions();
				connOpts.setCleanSession(true);
				System.out.println("Connecting to broker: " + broker);
				sampleClient.connect(connOpts);
				System.out.println("Connected");
				System.out.println("Publishing message: " + content);
				MqttMessage message = new MqttMessage(content.getBytes());
				message.setQos(qos);
				sampleClient.publish(topic, message);
				System.out.println("Message published");
				sampleClient.disconnect();
				System.out.println("Disconnected");
				System.exit(0);
			} catch (MqttException me) {
				System.out.println("reason " + me.getReasonCode());
				System.out.println("msg " + me.getMessage());
				System.out.println("loc " + me.getLocalizedMessage());
				System.out.println("cause " + me.getCause());
				System.out.println("excep " + me);
				me.printStackTrace();
			}

		}

	}

}
