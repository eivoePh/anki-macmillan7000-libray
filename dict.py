#!/usr/bin/python
# -*- coding: utf-8 -*-

import sys
import re
from DictionaryServices import *

def main():
    try:
        searchword = sys.argv[1].decode('utf-8')
    except IndexError:
        errmsg = 'You did not enter any terms to look up in the Dictionary.'
        print errmsg
        sys.exit()
    wordrange = (0, len(searchword))
    dictresult = DCSCopyTextDefinition(None, searchword, wordrange)
    if not dictresult:
        errmsg = "'%s' not found in Dictionary." % (searchword)
        print errmsg.encode('utf-8')
    else:
        result = dictresult.encode('utf-8')
        result = re.sub(r'\|', '\n', result)
        result = re.sub(r'①', '\n①', result)
        result = re.sub(r'②', '\n②', result)
        result = re.sub(r'③', '\n③', result)
        result = re.sub(r'④', '\n④', result)
        result = re.sub(r'⑤', '\n⑤', result)
        result = re.sub(r'⑥', '\n⑥', result)
        result = re.sub(r'⑦', '\n⑦', result)
        result = re.sub(r'⑧', '\n⑧', result)
        result = re.sub(r'⑨', '\n⑨', result)
        result = re.sub(r'⑩', '\n⑩', result)
        result = re.sub(r'⑪', '\n⑪', result)
        result = re.sub(r'⑫', '\n⑫', result)
        result = re.sub(r'⑬', '\n⑬', result)
        result = re.sub(r'⑭', '\n⑭', result)
        result = re.sub(r'⑮', '\n⑮', result)
        result = re.sub(r'⑯', '\n⑯', result)
        result = re.sub(r'⑰', '\n⑰', result)
        result = re.sub(r'⑱', '\n⑱', result)
        result = re.sub(r'⑲', '\n⑲', result)
        result = re.sub(r'⑳', '\n⑳', result)

        #result = re.sub(r'A\.', '\nA. ', result)
        result = re.sub(r'B\.', '\nB. ', result)
        result = re.sub(r'C\.', '\nC. ', result)
        result = re.sub(r'D\.', '\nD. ', result)
        result = re.sub(r'E\.', '\nE. ', result)
        result = re.sub(r'F\.', '\nF. ', result)
        result = re.sub(r'G\.', '\nG. ', result)
        result = re.sub(r'H\.', '\nH. ', result)
        result = re.sub(r'I\.', '\nI. ', result)
        result = re.sub(r'J\.', '\nJ. ', result)
        result = re.sub(r'K\.', '\nK. ', result)
        result = re.sub(r'L\.', '\nL. ', result)
        result = re.sub(r'M\.', '\nM. ', result)
        result = re.sub(r'N\.', '\nN. ', result)


        result = re.sub(r' 1 ', '\n1 ', result)
        result = re.sub(r' 2 ', '\n2 ', result)
        result = re.sub(r' 3 ', '\n3 ', result)
        result = re.sub(r' 4 ', '\n4 ', result)
        result = re.sub(r' 5 ', '\n5 ', result)
        result = re.sub(r' 6 ', '\n6 ', result)
        result = re.sub(r' 7 ', '\n7 ', result)
        result = re.sub(r' 8 ', '\n8 ', result)
        result = re.sub(r' 9 ', '\n9 ', result)
        result = re.sub(r' 10 ', '\n10 ', result)

        result = re.sub(r'▶', '\n▶', result)
        result = re.sub(r'•', '\n•' , result)

        result = re.sub(r'USAGE ', '\nUSAGE\n' , result)

        result = re.sub(r'\n ', '\n' , result)
        print result

if __name__ == '__main__':
    main()
