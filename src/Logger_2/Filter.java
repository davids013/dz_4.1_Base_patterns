package Logger_2;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final int THRESHOLD;
    private final Logger LOGGER = Logger.getInstance();

    public Filter(int threshold) {
        THRESHOLD = threshold;
        LOGGER.log("Создан экземпляр Filter");
    }

    public List<Integer> filterOut(List<Integer> list) {
        LOGGER.log("Идёт фильтрация списка");
        return list.stream().filter(e -> e >= THRESHOLD).collect(Collectors.toList());
    }
}