/**
 * 
 */
$(document).ready(function(){
	$('#label-list').table();
	$('#label-list-wrapper .add').click(function(){
		$('#label-modal').modal();
		$('#label-modal').load(ctx + '/label/form');
	});
	$('#label-modal').on('click', '.submit', function(){
		$('#label-form').ajaxSubmit({
			success: function(data){
				$('#label-modal').modal('hide');
				$('#label-list').table('load');
			}
		});
	});
});