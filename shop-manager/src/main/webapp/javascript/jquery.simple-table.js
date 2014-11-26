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
			var opts = $(this).data('opts');
			if(!opts){
				
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