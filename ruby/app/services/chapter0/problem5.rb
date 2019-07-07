# Keep track of the median as numbers are added to an array

require "algorithms"

module Chapter0
  class Problem5

    def initialize
      # Use two heaps to track the two middle most values in the most efficient way possible.
      @min_heap = Containers::MinHeap.new
      @max_heap = Containers::MaxHeap.new
      @array = []
    end

    def append_to_array(number)
      add_to_heaps(number)
      rebalance
      @array.append(number)
    end

    def median
      if @min_heap.size > @max_heap.size
        @min_heap.min
      elsif @max_heap.size > @min_heap.size
        @max_heap.max
      else
        (@min_heap.min + @max_heap.max).to_f / 2
      end
    end

    private

    def add_to_heaps(number)
      if !@max_heap.max.nil? && number > @max_heap.max
        @min_heap.push(number)
      else
        @max_heap.push(number)
      end
    end

    def rebalance
      if @max_heap.size - @min_heap.size > 1
        number = @max_heap.pop
        @min_heap.push(number)
      elsif @min_heap.size - @max_heap.size > 1
        number = @min_heap.pop
        @max_heap.push(number)
      end
    end
  end
end
