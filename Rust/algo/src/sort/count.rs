pub fn counting_sort(arr: &mut [usize]) {
    let max = arr.iter().max().unwrap();

    let mut temp = vec![0; max + 1];

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
