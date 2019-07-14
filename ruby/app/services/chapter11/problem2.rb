# Write a method to sort an array of strings so that all the anagrams are next to each other.

module Chapter11
  module Problem2
    extend self

    def solve(input)
      anagrams_storage = {}
      input.each do |string|
        sorted_string = string.chars.sort.join("")
        if anagrams_storage[sorted_string].nil?
          anagrams_storage[sorted_string] = []
          anagrams_storage[sorted_string].append(string)
        else
          anagrams_storage[sorted_string].append(string)
        end
      end

      output = []
      anagrams_storage.each do |_key, array|
        array.each do |string|
          output.append(string)
        end
      end

      output
    end
  end
end
