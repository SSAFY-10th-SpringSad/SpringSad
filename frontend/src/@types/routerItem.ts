export interface routerItem {
  path: string;
  element: React.ReactNode;
  withAuth: boolean;
  label: string;
  children?: routerItem[];
}
