# Write code to remove duplicates from an unsorted linked list

require "linked-list"

module Chapter2
  module Problem1
    extend self

    def solve(linked_list)
      items = {}
      linked_list.each do |item|
        if items[item].nil?
          items[item] = true
        else
          linked_list.delete(item)
        end
      end

      linked_list
    end
  end
end
