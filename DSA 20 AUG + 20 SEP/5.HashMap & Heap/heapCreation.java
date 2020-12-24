public static class PriorityQueue {
    ArrayList < Integer > data;

    public PriorityQueue() {
        data = new ArrayList < > ();
    }

    public void add(int val) {
        data.add(val);
        upHeapify(data.size() - 1);
    }
    private void swap(int i, int j) {
        int ith = data.get(i);
        int jth = data.get(j);

        data.set(i, jth);
        data.set(j, ith);
    }
    private void upHeapify(int idx) {
        if (idx == 0) {
            return;
        }

        int pidx = (idx - 1) / 2;
        if (data.get(pidx) > data.get(idx)) {
            swap(pidx, idx);
            upHeapify(pidx);
        }
    }

    public int remove() {
        if (data.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }

        swap(0, data.size() - 1);
        int val = data.remove(data.size() - 1);
        downHeapify(0);
        return val;
    }

    private void downHeapify(int pidx) {
        int lidx = (2 * pidx) + 1;
        int ridx = (2 * pidx) + 2;

        if (lidx < data.size() && ridx < data.size()) {
            int min = Math.min(Math.min(data.get(pidx), data.get(lidx)), data.get(ridx));

            if (min == data.get(lidx)) {
                swap(lidx, pidx);
                downHeapify(lidx);
            }
            if (min == data.get(ridx)) {
                swap(ridx, pidx);
                downHeapify(ridx);
            }
        } else if (lidx < data.size()) {
            int min = Math.min(data.get(pidx), data.get(lidx));
            if (min == data.get(lidx)) {
                swap(lidx, pidx);
                downHeapify(lidx);
            }
        }
    }

    public int peek() {
        if (data.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }
        return data.get(0);
    }

    public int size() {
        return data.size();
    }
}
