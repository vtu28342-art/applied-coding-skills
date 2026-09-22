class MyCircularQueue {
    int[] q;
    int f, r;
    int size, capacity;
    public MyCircularQueue(int k) {
        q = new int[k];
        f = r = -1;
        size = 0;
        capacity = k;
    }    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        else {
            r = (r + 1) % capacity;
            q[r] = value;
            if (f == -1)
                f = r;
        }
        size++;
        return true;
    }      
    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (f == r)
            f = r = -1;
        else
            f = (f + 1) % capacity;

        size--;
        return true;
    }    
    public int Front() {
        if (isEmpty())
            return -1;
        return q[f];
    }       
    public int Rear() {
        if (isEmpty())
            return -1;
        return q[r];
    }       
    public boolean isEmpty() {
        return size == 0;
    }        
    public boolean isFull() {
        return size == capacity;
    }
}
