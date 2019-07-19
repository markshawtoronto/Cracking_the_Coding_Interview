describe Chapter2::Problem1 do
  describe "#solve" do
    it "should handle a linked list with no duplicates" do
      linked_list = LinkedList::List.new
      linked_list << 1
      linked_list << 2
      linked_list << 3

      expect(Chapter2::Problem1.solve(linked_list).to_a).to eq [1, 2, 3]
    end

    it "should handle a linked list with duplicates" do
      linked_list = LinkedList::List.new
      linked_list << 1
      linked_list << 1
      linked_list << 3
      linked_list << 3
      linked_list << 3

      expect(Chapter2::Problem1.solve(linked_list).to_a).to eq [1, 3]
    end
  end
end
