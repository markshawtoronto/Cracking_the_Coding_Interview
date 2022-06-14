module Miscellaneous
  module MinimalTriangle

    # @param {Integer[][]} triangle
    # @return {Integer}
    def self.minimum_total(triangle)
      (triangle.length - 2).downto(0) do |i|
        triangle[i].each_with_index do |num, j|
          triangle[i][j] += [triangle[i + 1][j], triangle[i + 1][j + 1]].min
        end
      end
      triangle[0][0]
    end
  end
end
