import type { PageLoad } from './$types';

export const prerender = true;

export const load: PageLoad = () => {
	return {
		title: 'National Basemap of Lithuania Demo ',
	};
};
