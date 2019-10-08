package WS10;

import java.lang.*;
import java.util.*;

public class DSAHeap
{
    private class DSAHeapEntry
    {
        public int priority;
        public Object value;
        public DSAHeapEntry(int inPriority, Object inValue)
        {
            priority = inPriority;
            value = inValue;
        }
    }
    private DSAHeapEntry[] m_heap;
    private int m_count=0;
   
    public DSAHeap() // default constructor
    {
      m_heap = new DSAHeapEntry[100];
    }
    public DSAHeap(int maxSize) // set the DSAHeapEntry with given value
    {
      m_heap = new DSAHeapEntry[maxSize];
    }
    public void add(int priority, Object value) // add the value on the last then doing trickle up
    {
        DSAHeapEntry newEntry = new DSAHeapEntry(priority, value);
        m_heap[m_count] = newEntry;
        trickleUp(m_count);
        m_count++;
    }
    public void remove() // removed top one for using tickle down and last one make it null
    {
        m_heap[0] = m_heap[m_count];
        m_heap[m_count] = null;
        m_count--;
        trickleDown(0);
    }
    public void heapify() // to do heapify which has childs then do it
    {
        for(int i= m_count/2;  i>=0; i--)
        {
            trickleDown(i);
        }
    }
    public void heapSort() // sort the tree(array)
    {
        DSAHeapEntry temp;
        heapify();
        for(int i= m_count-1; i>0   ; i--)
        {
            temp = m_heap[0];
            m_heap[0] = m_heap[i];
            m_heap[i] = temp;
            trickleDown(0, i); // need to limit the range so need to use this form
        }
    }
    private void trickleUp(int index) // trickle up function
    {
      DSAHeapEntry temp;
      int parentIdx = (index - 1) / 2;
      while(index>0 && (m_heap[index].priority > m_heap[parentIdx].priority))
      {
          temp = m_heap[parentIdx];
          m_heap[parentIdx] = m_heap[index];
          m_heap[index] = temp;
          index = parentIdx;
          parentIdx = (index -1) / 2 ;
      }
    }
    private void trickleDown(int index) // for default function of trickle down
    {
        int lChildIdx = index*2 + 1, rChildIdx = lChildIdx +1, largeIdx;
        DSAHeapEntry temp;
        if(lChildIdx <m_count)
        {
         largeIdx = lChildIdx;
         if(rChildIdx < m_count)
         {
          if(m_heap[lChildIdx].priority < m_heap[rChildIdx].priority)
           largeIdx = rChildIdx;
         }
         if(m_heap[largeIdx].priority > m_heap[index].priority)
         {
             temp = m_heap[largeIdx];
             m_heap[largeIdx] = m_heap[index];
             m_heap[index] = temp;
             trickleDown(largeIdx);
         }
        }
    }
    private void trickleDown(int index, int num) // for sort because sort need to change limited number of item to swap
    {
        int lChildIdx = index*2 + 1, rChildIdx = lChildIdx +1, largeIdx;
        DSAHeapEntry temp;
        if(lChildIdx <num)
        {
         largeIdx = lChildIdx;
         if(rChildIdx < num)
         {
          if(m_heap[lChildIdx].priority < m_heap[rChildIdx].priority)
           largeIdx = rChildIdx;
         }
         if(m_heap[largeIdx].priority > m_heap[index].priority)
         {
             temp = m_heap[largeIdx];
             m_heap[largeIdx] = m_heap[index];
             m_heap[index] = temp;
             trickleDown(largeIdx, num);
         }
        }
    }
}
    