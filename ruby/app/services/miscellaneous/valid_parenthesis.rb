# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

module Miscellaneous
  module ValidParenthesis
    extend self

    # @param {String} s
    # @return {Boolean}
    def is_valid(s)
      stack = []
      s.chars.each do |c|
        if c == "(" || c == "{" || c == "["
          stack.push(c)
        elsif c == ")"
          last_bracket = stack.pop()
          if last_bracket != "("
            return false
          end
        elsif c == "}"
          last_bracket = stack.pop()
          if last_bracket != "{"
            return false
          end
        elsif c == "]"
          last_bracket = stack.pop()
          if last_bracket != "["
            return false
          end
        end
      end

      stack.empty?
    end
  end
end