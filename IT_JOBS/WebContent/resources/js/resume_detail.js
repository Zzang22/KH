

function submitTable(obj) {

	var queryStr = $(obj).serialize();

	$.ajax({
		url: 'indimember.do?' + queryStr,
		method: 'post',
		datatype: 'text',
		success: function(msg) {
			alert('수정 성공');
			location.href = "indimember.do?command=resume-detail&rs_no=" + msg;
		},
		error: function() {
			alert('수정 실패');
		}
	});

}



function cancleAc() {
	$("#ac_update_table").find('table').remove();
	$("#ac_table").show();
	$('#updateAcBtn').show();
	$('#cancleAcBtn').hide();

}


function delTr(obj) {
	var tr = $(obj).parent().parent();
	var input = tr.prev("input[name=rs_ac_no]");
	tr.remove();
	input.remove();
}


function cancleCr(){
	$('#cr_update_table').find('table').remove();
	$('#cr_table').show();
	$('#updateCrBtn').show();
	$('#cancleCrBtn').hide();
}

function delCrTr(obj){
	var tr = $(obj).parent().parent();
	var input = tr.prev('input[name=rs_cr_no]');
	tr.remove();
	input.remove();
}


function cancleLc(){
	$('#lc_update_table').find('table').remove();
	$('#lc_table').show();
	$('#updateLcBtn').show();
	$('#cancleLcBtn').hide();
}

function delLcTr(obj){
	var tr = $(obj).parent().parent();
	var input = tr.prev('input[name=rs_lc_no]');
	tr.remove();
	input.remove();
}