# @param {String} s1
# @param {String} s2
# @return {Boolean}
def check_inclusion(s1, s2)
    left = 0
    right = 0
    map = {}
    curr_res = {}
    alphabet = "abcdefghijklmnopqrstuvwxyz"

    alphabet.each_char do |ch|
        map[ch] = 0
        curr_res[ch] = 0
    end

    s1.each_char do |ch|
        map[ch] += 1
    end

    while right < s2.length
        if right >= s1.length
            curr_res[s2[left]] -= 1
            curr_res[s2[right]] += 1
            left += 1
        else
            curr_res[s2[right]] += 1
        end

        right += 1
        return true if curr_res == map
    end

    return false
end