describe Miscellaneous::MinimalTriangle do
  describe "#minimum_total" do
    it "should calculate small triangles" do
      expect(Miscellaneous::MinimalTriangle.minimum_total([[2],[3,4],[6,5,7],[4,1,8,3]])).to eq 11
    end
  end
end