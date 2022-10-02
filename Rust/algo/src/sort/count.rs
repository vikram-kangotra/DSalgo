pub fn counting_sort(arr: &mut [usize]) {
    let mut max = arr[0];
    for val in arr.iter() {
        if max < *val {
            max = *val;
        }
    }

    let mut temp = Vec::new();
    temp.resize(max + 1, 0);

    for val in arr.iter() {
        temp[*val] += 1;
    }

    let mut j = 0;

    for i in 0..temp.len() {
        for _ in 0..temp[i] {
            arr[j] = i;
            j += 1;
        }
    }
}
