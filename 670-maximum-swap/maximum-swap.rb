# @param {Integer} num
# @return {Integer}
def maximum_swap(num)
    num_array = num.to_s.chars
    max_num = num

    for i in 0...num_array.length
        for j in i+1...num_array.length
            temp = num_array[i]
            num_array[i] = num_array[j]
            num_array[j] = temp

            curr_num = num_array.join.to_i
            max_num = [max_num, curr_num].max

            temp = num_array[i]
            num_array[i] = num_array[j]
            num_array[j] = temp
        end
    end

    return max_num
end