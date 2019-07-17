# You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
# Write a method to merge B into A in sorted order

module Chapter11
  module Problem1
    extend self

    def solve(a, b)
      i = 0
      j = 0
      output = []

      until i == a.length && j == b.length
        if j == b.length || a[i] < b[j]
          output.append(a[i])
          i += 1
        else
          output.append(b[j])
          j += 1
        end
      end

      output
    end
  end
end
