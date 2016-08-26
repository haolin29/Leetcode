public class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(maxHeap.size() == 0 || num <= maxHeap.peek()) {
            if(maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            maxHeap.offer(num);
        } else if (minHeap.size() == 0 || num > minHeap.peek()) {
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            minHeap.offer(num);
        // 数字在堆顶，哪个堆少入哪个
        } else {
            if(maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
        
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if(maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else if(maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0 ;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();