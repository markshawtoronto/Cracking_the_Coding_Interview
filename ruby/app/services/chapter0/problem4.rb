# Print all permutations of a string with unique characters

module Chapter0
  module Problem4
    extend self

    def solve(input)
      return [ input ] if input.length == 1

      last_char = input.last
      input_without_last_char = input.chop
      character_count = input.length

      other_arrangements = solve(input_without_last_char)

      output = []
      other_arrangements.each do |arrangement|
        character_count.times do |counter|
          temp_string = arrangement.clone
          output << temp_string.insert(counter, last_char)
        end
      end

      output.sort
    end
  end
end
