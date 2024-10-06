# @param {String} sentence1
# @param {String} sentence2
# @return {Boolean}
def are_sentences_similar(sentence1, sentence2)
    w1 = sentence1.split(" ")
    w2 = sentence2.split(" ")

    return true if w1 == w2

    prefix = []
    suffix = []

    n = w1.length
    m = w2.length

    [n,m].min.times do |i|
        if w1[i] == w2[i]
            prefix << w1[i]
        else
            break
        end
    end

    [n,m].min.times do |i|
        if w1[n-1-i] == w2[m-1-i]
            suffix << w1[n-1-i]
        else
            break
        end
    end

    suffix.reverse!

    while prefix.length + suffix.length > [n,m].min
        if !suffix.empty? && !prefix.empty? && prefix.last == suffix.first
            prefix.pop
        else
            break
        end
    end

    prefix.concat(suffix)

    prefix == w1 || prefix == w2
end