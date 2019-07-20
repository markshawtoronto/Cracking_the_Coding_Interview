describe Miscellaneous::SherlockAnagram do
  context "#solve" do
    it "should identify pairs of substrings which are anagrams" do
      expect(Miscellaneous::SherlockAnagram.solve("abba")).to eq 4
    end

    it "should handle all the same letters" do
      expect(Miscellaneous::SherlockAnagram.solve("kkkk")).to eq 10
    end
  end

  context "#anagram" do
    it "should identify two anagrams" do
      expect(Miscellaneous::SherlockAnagram.anagram("mom", "mmo")).to eq true
    end

    it "should identify two non-anagrams" do
      expect(Miscellaneous::SherlockAnagram.anagram("moms", "mmo")).to eq false
    end
  end
end
