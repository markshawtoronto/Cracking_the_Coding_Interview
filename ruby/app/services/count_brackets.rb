# Determine if there are any unclosed brackets in a string.

class CountBrackets
  def self.determine(input)
    open_bracket_count = 0
    input.each_char do |letter|
      if letter == "("
        open_bracket_count += 1
      elsif letter == ")"
        open_bracket_count -= 1
      end

      if open_bracket_count.negative?
        return false
      end
    end

    open_bracket_count.zero?
  end
end
