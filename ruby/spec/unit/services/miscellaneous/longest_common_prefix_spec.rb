describe Miscellaneous::LongestCommonPrefix do
  describe "#longest_common_prefix" do
    it "should handle cases where there's a common prefix found" do
      expect(Miscellaneous::LongestCommonPrefix.longest_common_prefix(["flower","flow","flight"])).to eq "fl"
    end

    it "should handle cases where there's no common prefix" do
      expect(Miscellaneous::LongestCommonPrefix.longest_common_prefix(["dog","racecar","car"])).to eq ""
    end

    it "should handle short strings" do
      expect(Miscellaneous::LongestCommonPrefix.longest_common_prefix(["cir","car"])).to eq "c"
    end
  end
end
