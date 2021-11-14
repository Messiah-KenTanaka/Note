
const DELETE_MESSAGE = "本当に削除してもよろしいですか？"
$('.delete-action').click(function() {
	if(!confirm(DELETE_MESSAGE)){
		return false;
	}
});