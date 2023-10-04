public class Stack {
    private int[] arr;
    private int size, cur_size, pop_pos, push_pos;
    Stack(int size)
    {
        arr = new int[size];
        this.size = size;
        cur_size = 0;
        pop_pos = 0;
        push_pos = -1;
    }
    public void push( int val )
    {
        if( cur_size != size )
        {
            push_pos = (push_pos + 1 ) % size;
            arr[push_pos] = val;
            cur_size++;
        }
    }
    public int pop()
    {
        if( cur_size != 0 )
        {
            int item = arr[pop_pos];
            pop_pos = (pop_pos + 1) % size;
            cur_size--;
            return item;
        }
        return -1000000000;
    }

    public boolean isFull()
    {
        if( this.cur_size == this.size )
            return true;
        return false;
    }
    public boolean isEmpty()
    {
        if( this.cur_size == 0 )
            return true;
        return false;
    }

}
