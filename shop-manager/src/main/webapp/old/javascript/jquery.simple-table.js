/**
 * 
 */
(function($){
	function init(jq){
		
	};
	function request(jq, param){
		
	};
	function renderTable(jq, data){
		
	};
	$.fn.table = function(option, param){
		if(typeof option == 'string'){
			return $.fn.table.methods[option](this, param);
		}
		return this.each(function(){
			init(this);
			var opts = $(this).data('options');
			if(!opts){
				var columns = [];
				$(this).find('colgroup').children().each(function(){
					columns.push({
						dataIndex: $(this).attr('data-index')
					});
				});
				opts.columns = columns;
				$(this).data('options', opts);
			}
		});
	};
	$.fn.table.methods = {
		load: function(jq, param){
			return jq.each(function(){
				request(this, param);
			});
		}	
	};
	$.fn.table.parseOptions = function(jq){
		var t = $(jq);
		var clonum = [];
		return $.extend({}, {
			
		});
	};
})(jQuery);