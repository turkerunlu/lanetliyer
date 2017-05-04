kardes1=int(raw_input('birinci kardesin yasini giriniz: '))
kardes2=int(raw_input('ikinci kardesin yasini giriniz: '))
fark=kardes1-kardes2
toplam=kardes1+kardes2
if fark<0:
	fark=fark*-1
print 'farklari=%d dir'%fark
print 'toplamlari=%d dir'%toplam
