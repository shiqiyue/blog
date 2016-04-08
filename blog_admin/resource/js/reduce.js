reduce=function (key,values){
	var result = 0;
	for (var value in values){
		result+=value;
	}
	return result;
}