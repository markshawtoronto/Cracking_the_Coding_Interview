module Chapter1
  class Problem8
    def solve(s1, s2)
      return false if s1.length != s2.length

      target = s2.chars.first

      s1.chars.each_with_index do |char_1, index|
        if char_1 == target
          unrotated = s1[index..s1.length - 1] + s1[0..index - 1]
          return true if unrotated == s2
        end
      end

      false
    end
  end
end
