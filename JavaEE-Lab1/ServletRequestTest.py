import csv

with open('C:/Users/Robert/Desktop/Test1.csv') as csv_file1:  # mock = false, sync = false
    latencySumFile1 = 0
    csv_reader = csv.reader(csv_file1, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            line_count += 1
        else:
            latencySumFile1 += int(row[14])
            line_count += 1
    print('First file latency average is ' + str((latencySumFile1 / line_count)))

with open('C:/Users/Robert/Desktop/Test2.csv') as csv_file2:  # mock = false, sync = true
    latencySumFile2 = 0
    csv_reader = csv.reader(csv_file2, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            line_count += 1
        else:
            latencySumFile2 += int(row[14])
            line_count += 1
    print('Second file latency average is ' + str((latencySumFile2 / line_count)))

with open('C:/Users/Robert/Desktop/Test3.csv') as csv_file4:  # mock = true, sync = false
    latencySumFile3 = 0
    csv_reader = csv.reader(csv_file4, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            line_count += 1
        else:
            latencySumFile3 += int(row[14])
            line_count += 1
    print('Third file latency average is ' + str((latencySumFile3 / line_count)))

with open('C:/Users/Robert/Desktop/Test4.csv') as csv_file4:  # mock = true, sync = true
    latencySumFile4 = 0
    csv_reader = csv.reader(csv_file4, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            line_count += 1
        else:
            latencySumFile4 += int(row[14])
            line_count += 1
    print('Fourth file latency average is ' + str((latencySumFile4 / line_count)))
