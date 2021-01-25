package app;

import Exceptions.SensorException;
import app.Collector;
import app.CollectorImpl;
import org.junit.Assert;
import org.junit.Test;
import sensordata.SensorData;
import sensordata.SensorDataImpl;

import java.util.LinkedList;

public class SensorDataSpeicherTest {


        private LinkedList<SensorData> getSensorList() {
            LinkedList<SensorData> sensorDataLL = new LinkedList<>();
            SensorData s1 = new SensorDataImpl(2984394, 0.6f, "sensor1");
            SensorData s2 = new SensorDataImpl(2984374, 0.2f, "sensor2");
            SensorData s3 = new SensorDataImpl(3984394, 0.4f, "sensor1");
            SensorData s4 = new SensorDataImpl(2984394, 0.6f, "sensor1");
            SensorData s5 = new SensorDataImpl(2984374, 0.8f, "sensor2");
            SensorData s6 = new SensorDataImpl(3984394, 0.4f, "sensor1");
            sensorDataLL.add(s1);
            sensorDataLL.add(s2);
            sensorDataLL.add(s3);
            sensorDataLL.add(s4);
            sensorDataLL.add(s5);
            sensorDataLL.add(s6);

            return sensorDataLL;
        }

    private LinkedList<SensorData> getMaxValuesSensorList() {
        LinkedList<SensorData> sensorDataLL = new LinkedList<>();
        SensorData s1 = new SensorDataImpl(2984394, Float.MAX_VALUE, "sensor1");
        SensorData s2 = new SensorDataImpl(2984374, Float.MIN_VALUE, "sensor2");
        SensorData s3 = new SensorDataImpl(3984394, Float.MAX_VALUE, "sensor1");
        SensorData s4 = new SensorDataImpl(2984394, Float.MAX_VALUE, "sensor1");
        SensorData s5 = new SensorDataImpl(2984374, Float.MIN_VALUE, "sensor2");
        SensorData s6 = new SensorDataImpl(3984394, Float.MAX_VALUE, "sensor1");
        sensorDataLL.add(s1);
        sensorDataLL.add(s2);
        sensorDataLL.add(s3);
        sensorDataLL.add(s4);
        sensorDataLL.add(s5);
        sensorDataLL.add(s6);

        return sensorDataLL;
    }

    Collector collector = new CollectorImpl();


         @Test
        public void gutTestAverageOneSensor() throws Exception {
            float average = collector.getAverageOneSensor(getSensorList(), "sensor1");
            Assert.assertEquals(0.5f, average, 0.001f);
        }


        @Test
        public void gutTestAverageAllSensors() throws Exception {
            float average = collector.getAverageAllSensors(getSensorList());
            Assert.assertEquals(0.5f, average, 0.001f);

        }


        @Test(expected=Exception.class)
        public void schlechtTestAverageOneSensor() throws SensorException {
             collector.getAverageOneSensor(getSensorList(), "sensor3");

        }

        @Test(expected=Exception.class)
        public void schlechtTestAverageAllSensors() throws SensorException {
             collector.getAverageAllSensors(null);

        }

        @Test
        public void badRandTest() throws SensorException {
             float average = collector.getAverageOneSensor(getMaxValuesSensorList(), "sensor1");

             Assert.assertNotEquals(Float.MAX_VALUE, average, 0.001f);

         }


    }



