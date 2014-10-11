import java.util.ArrayList;
import java.util.List;

/**
 * Created by minjian.cai on 2014/10/10.
 */
class CountedInterger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    public Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElenments) throws IllegalAccessException, InstantiationException {
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < nElenments; i++) {
            result.add(type.newInstance());
        }
        return result;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        FilledList<CountedInterger> fl = new FilledList<CountedInterger>(CountedInterger.class);
        System.out.println(fl.create(15));
    }
}
