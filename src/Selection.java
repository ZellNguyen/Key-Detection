import java.util.Random;

/**
 * Created by Zell on 12/4/15.
 */
public class Selection {
    public Note quickselect(Note[] G, int k) {
        return quickselect(G, 0, G.length - 1, k - 1);
    }

    private Note quickselect(Note[] G, int first, int last, int k) {
        if (first <= last) {
            int pivot = partition(G, first, last);
            if (pivot == k) {
                return G[k];
            }
            if (pivot > k) {
                return quickselect(G, first, pivot - 1, k);
            }
            return quickselect(G, pivot + 1, last, k);
        }
        return Note.C3;
    }

    private int partition(Note[] G, int first, int last) {
        int pivot = first + new Random().nextInt(last - first + 1);
        swap(G, last, pivot);
        for (int i = first; i < last; i++) {
            if (G[i].percentage > G[last].percentage) {
                swap(G, i, first);
                first++;
            }
        }
        swap(G, first, last);
        return first;
    }

    private void swap(Note[] G, int x, int y) {
        Note tmp = G[x];
        G[x] = G[y];
        G[y] = tmp;
    }
}
