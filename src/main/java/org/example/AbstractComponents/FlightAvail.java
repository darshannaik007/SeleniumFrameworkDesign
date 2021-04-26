package org.example.AbstractComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FlightAvail {

    void checkAvail(List<HashMap<String, String>> reservation1, Map<String, String> reservation2);

}
